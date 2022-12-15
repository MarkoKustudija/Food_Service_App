// import { Link } from 'react-router-dom';
import classes from './NoMealsFound.module.css';

const NoMealsFound  =  props => {
    return (
        <div className={classes.nomeals}>
          <p> 404 - No meals found!</p>
          {/* <Link className="btn" to="/new-meal">
            Add New Meal
          </Link> */}
        </div>
      );
}

export default NoMealsFound;