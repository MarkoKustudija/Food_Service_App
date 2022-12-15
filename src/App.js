import { useContext, useState } from "react";
import Header from "./components/Layout/Header";
import Meals from "./components/Meals/Meals";
import Cart from "./components/Cart/Cart";
import CartProvider from "./store/CartProvider";
import { Route, Redirect, Switch } from "react-router-dom";
import AuthPage from "./pages/AuthPage";
import AuthContext from "./store/auth-context";


function App() {
  const authCtx = useContext(AuthContext);

  const [cartIsShown, setCartIsShown] = useState(false);

  const showCartHandler = () => {
    setCartIsShown(true);
  };

  const hideCartHandler = () => {
    setCartIsShown(false);
  };

  return (
    <CartProvider>
      {cartIsShown && <Cart onClose={hideCartHandler} />}
   
      <Header onShowCart={showCartHandler} />
      <Switch>
        <main>
          {!authCtx.isLoggedIn && (
            <Route path="/auth">
              <AuthPage />
            </Route>
          )}

          <Route path="/" exact>
            <Redirect to="/meals" />
          </Route>

          <Route path="/meals" exact>
            <Meals />
          </Route>
        </main>
      </Switch>

   
    </CartProvider>
  );
}

export default App;
