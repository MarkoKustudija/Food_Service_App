import MealItem from "./MealItem/MealItem";
import Card from "../UI/Card";
import { useEffect, useState } from "react";
import classes from "./AvailableMeals.module.css";

const DUMMY_MEALS = [
  {
    id: "m1",
    name: "Pizza Napolitana",
    description: "The best pizza from Naples",
    price: 22.99,
  },
  {
    id: "m2",
    name: "Pasta Carbonara",
    description: "Delicious pasta",
    price: 16.5,
  },
  {
    id: "m3",
    name: "Lazania con carne",
    description: "The Best of Italy ",
    price: 12.99,
  },
  {
    id: "m4",
    name: "Ravioli con ricotta",
    description: "No words need it...",
    price: 18.99,
  },
];

const AvailableMeals = (props) => {
  const setMeals = useState([DUMMY_MEALS])[1];
  const [isLoading, setIsLoading] = useState(false);
  const [httpError, setHttpError] = useState();

  

  useEffect(() => {
    setIsLoading(true);
    const fetchMeals = async () => {
      const response = await fetch(
        //  "http://localhost:8080/api/meals"
        'https://lacucinaitaliana-e86ec-default-rtdb.europe-west1.firebasedatabase.app/meals.json'
    
      );

      if (!response.ok) {
        throw new Error("Something went wrong!");
      }
      const responseData = await response.json();
      // console.log(responseData);

      const loadedMeals = [];

      for (const key in responseData) {
        loadedMeals.push({
          id: key,
          name: responseData[key].name,
          description: responseData[key].description,
          price: responseData[key].price,
        });
      }
      setMeals(loadedMeals);
      setIsLoading(false);
    };
    fetchMeals().catch((error) => {
      setIsLoading(false);
      setHttpError(error.message);
    });
  }, [setMeals]);

  if (isLoading) {
    return (
      <section className={classes.MealsLoading}>
        <p> Loading ...</p>
      </section>
    );
  }

  if (httpError) {
    return (
      <section className={classes.MealsError}>
        <p>{httpError}</p>
      </section>
    );
  }

  const mealsList = DUMMY_MEALS.map((mealItem) => {
  // const mealsList = meals.map((mealItem) => {
    return (
      <MealItem
        id={mealItem.id}
        key={mealItem.id}
        name={mealItem.name}
        description={mealItem.description}
        price={mealItem.price}
      />
    );
  });

  return (
    <section className={classes.meals}>
      <Card>
        <ul>{mealsList}</ul>
      </Card>
    </section>
  );
};

export default AvailableMeals;
