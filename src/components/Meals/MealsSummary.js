import { useContext } from "react";
import AuthContext from "../../store/auth-context";
import classes from "../Meals/MealsSummary.module.css";

const MealsSummary = (props) => {

  const authCtx = useContext(AuthContext);
  const isLoggedIn = authCtx.isLoggedIn;
  return (

    <section className={classes.summary}>
      <h2>Delicious Food, Delivered To You</h2>

      <p>
        Choose your favorite meal from our broad selection of available meals
        and enjoy a delicious lunch or dinner at home.
      </p>
      <p>
        All our meals are cooked with high-quality ingredients, just-in-time and
        of course by experienced chefs!
      </p>

      {!isLoggedIn && <h3>
        For ordering your food you first need to make account and to Login !!!
      </h3>}
      
    </section>
  );
};

export default MealsSummary;
