import { useContext } from "react";
// import Header from "./components/Layout/Header";
// import Meals from "./components/Meals/Meals";
// import Cart from "./components/Cart/Cart";
// import CartProvider from "./store/CartProvider";
import { Route, Redirect, Switch } from "react-router-dom";
import AuthPage from "./pages/AuthPage";
import AuthContext from "./store/auth-context";
import Layout from "./components/layout/Layout";
// import AllMeals from "./pages/AllMeals";
import Meals from "./components/Meals/Meals";

function App() {
  const authCtx = useContext(AuthContext);

  return (
    <Layout>
      <Switch>
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
        
      </Switch>
    </Layout>
  );
}

export default App;
