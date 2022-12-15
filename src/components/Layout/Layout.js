import { Fragment, useState } from "react";
import classes from "./Layout.module.css";
import Header from "./Header";
import CartProvider from "../../store/CartProvider";
// import AuthContext from "../../store/auth-context";
import Cart from '../Cart/Cart';

const Layout = (props) => {

    const [cartIsShown, setCartIsShown] = useState(false);

  
    const showCartHandler = () => {
      setCartIsShown(true);
    };
  
    const hideCartHandler = () => {
      setCartIsShown(false);
    };
  return (
    <Fragment>
      <CartProvider>
      {cartIsShown && <Cart onClose={hideCartHandler} />}
        <Header onShowCart={showCartHandler} />
        <main className={classes.main}> {props.children}</main>
      </CartProvider>
    </Fragment>
  );
};

export default Layout;
