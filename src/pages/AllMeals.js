import { getAllMeals } from "../lib/app";
import useHttp from '../hooks/use-http';
import LoadingSpinner from '../components/UI/LoadingSpinner';
import { Fragment, useEffect } from "react";
import NoMealsFound from "../components/Meals/NoMealsFound";
import Meals from "../components/Meals/Meals";

const AllMeals = props => {

    const {
        sendRequest,
        status,
        data: loadedMeals,
        error,
      } = useHttp(getAllMeals, true);
  
      useEffect(() => {
        sendRequest();
      }, [sendRequest]);
  
      if (status === "pending") {
        return (
          <div className="centered">
            <LoadingSpinner/>
          </div>
        );
      }
  
      if (error) {
        return <p className="centered focused">{error}</p>;
      }
  
      if (status === "completed" && (!loadedMeals || loadedMeals.length === 0)) {
        return <NoMealsFound />;
      }

      return(
        <Fragment>
            <Meals meals = {loadedMeals} />
        </Fragment>
      )

}

export default AllMeals;