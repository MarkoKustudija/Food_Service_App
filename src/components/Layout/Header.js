import { Fragment, useContext } from "react";
import { NavLink } from "react-router-dom";
import mealsImage from "../../assets/meals.jpeg";
import AuthContext from "../../store/auth-context";
import classes from "./Header.module.css";
import HeaderCartButton from "./HeaderCartButton";

const Header = (props) => {
  const authCtx = useContext(AuthContext);
  const isLoggedIn = authCtx.isLoggedIn;

  const logoutHandler = () => {
    authCtx.logout();
    // history.replace('/');
  };

  return (
    <Fragment>
      <header className={classes.header}>
        <div className={classes.logo}>
          <h3>Italian Cucina</h3>
        </div>

        <nav className={classes.nav}>
          <ul>
            {!isLoggedIn && (
              <li>
                <NavLink to="/home" activeClassName={classes.active}>
                  <h3> Home </h3>
                </NavLink>
              </li>
            )}

            {!isLoggedIn && (
              <li>
                <NavLink to="/meals" activeClassName={classes.active}>
                  <h3> Menu </h3>
                </NavLink>
              </li>
            )}

            {!isLoggedIn && (
              <li>
                <NavLink to="/auth" activeClassName={classes.active}>
                  <h3> Login </h3>
                </NavLink>
              </li>
            )}

            {isLoggedIn && (
              <li>
                <NavLink to="/meals" activeClassName={classes.active}>
                  <h3> Menu </h3>
                </NavLink>
              </li>
            )}

            {isLoggedIn && (
              <li>
                <button className={classes.button} onClick={logoutHandler}>
                  Logout
                </button>
              </li>
            )}
          </ul>
        </nav>
        {isLoggedIn && <HeaderCartButton onClick={props.onShowCart} />}
        {/* <HeaderCartButton onClick={props.onShowCart} /> */}
      </header>

      <div className={classes["main-image"]}>
        <img src={mealsImage} alt="A table full of delicious food!" />
      </div>
    </Fragment>
  );
};

export default Header;
