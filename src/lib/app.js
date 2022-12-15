const FIREBASE_DOMAIN =
'https://socialnetwork-f896f-default-rtdb.europe-west1.firebasedatabase.app/'


export async function getAllMeals() {
    const response = await fetch(`${FIREBASE_DOMAIN}/meals.json`);
    // const response = await fetch('http://localhost:8080/api/meals');
    const data = await response.json();
  
    if (!response.ok) {
      throw new Error(data.message || "Could not fetch meals.");
    }
  
    const transformedMeals = [];
  
    for (const key in data) {
      const mealObj = {
        id: key,
        ...data[key],
      };
      transformedMeals.push(mealObj);
    }
    return transformedMeals;
  }