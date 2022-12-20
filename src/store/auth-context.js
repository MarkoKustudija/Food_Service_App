import React, { useCallback, useEffect, useState } from "react";

let logoutTimer;

const AuthContext = React.createContext({
    token: '',
    isLoggedIn: false,
    login : (token) => {},
    logout: () => {}

});

// calculate time
const calculateRemaingTime = (expirationTime) => {
  const currentTime = new Date().getTime();
  const adjExpirationTime = new Date(expirationTime).getTime();

  const remainingDuration = adjExpirationTime - currentTime;

  return remainingDuration;
};

// function that retrives token
const retriveStoredToken = () => {
  const storedToken = localStorage.getItem("token");
  const storedExpirationDate = localStorage.getItem("expirationTime");

  const remainingTime = calculateRemaingTime(storedExpirationDate);

  if (remainingTime <= 3600) {
    localStorage.removeItem("token");
    localStorage.removeItem("expirationTime");
    return null;
  }

  return {
    token: storedToken,
    duration: remainingTime,
  };
};


export const AuthContextProvider = (props) => {
  const tokenData = retriveStoredToken();
  let initialToken;

  if(tokenData){
    initialToken = tokenData.token;
  }

  const [token, setToken] = useState(initialToken);

  const userIsLoggedIn = !!token;

  // Loguot
  const logoutHandler = useCallback(() => {
   
    setToken(null);
    localStorage.removeItem('token');
    localStorage.removeItem('expirationTime');
    
    if(logoutTimer) {
        clearTimeout(logoutTimer);
    }
  },[]);

  // Login
  const loginHandler = (token, expirationTime) => {
    setToken(token);
    localStorage.setItem('token', token);
    localStorage.setItem('expirationTime', expirationTime);
    
    const remainingTime = calculateRemaingTime(expirationTime);
    logoutTimer = setTimeout(logoutHandler, remainingTime);
  };

  // useEffect
  useEffect(() => {
    if(tokenData){
        // console.log(tokenData.duration);
        logoutTimer = setTimeout(logoutHandler, tokenData.duration);
    }
  }, [tokenData,logoutHandler]);
  

  const contextValue = {
    token: token,
    isLoggedIn: userIsLoggedIn,
    login: loginHandler,
    logout: logoutHandler,
  }

  return (
    <AuthContext.Provider value={contextValue}>
        {props.children}
    </AuthContext.Provider>
  )

};

export default AuthContext;
