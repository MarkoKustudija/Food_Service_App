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
import Home from "./components/Home/Home";
import NotFound from './pages/NotFound';

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

         {/* <Route path="/" exact>
          <Redirect to="/home" />
        </Route> */}

        <Route path="/home" exact>
          <Home />
        </Route>

        <Route path="/" exact>
          <Redirect to="/meals" />
        </Route>

        <Route path="/meals" exact>
          <Meals />
        </Route>

        <Route path="*">
          <NotFound />
        </Route>

      </Switch>
    </Layout>
  );
}

export default App;
