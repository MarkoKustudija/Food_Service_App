import classes from "./Home.module.css";
import MealsSummary from '../Meals/MealsSummary';
const Home = () => {
  return (
    <div className={classes.home}>
      <MealsSummary />
    </div>
  );
};

export default Home;
