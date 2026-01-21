package generics;

interface MealPlan {
    void prepare();
}

class VegetarianMeal implements MealPlan {
    public void prepare() {
        System.out.println("Preparing Vegetarian Meal");
    }
}

class VeganMeal implements MealPlan {
    public void prepare() {
        System.out.println("Preparing Vegan Meal");
    }
}

class KetoMeal implements MealPlan {
    public void prepare() {
        System.out.println("Preparing Keto Meal");
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void serve() {
        mealPlan.prepare();
    }
}

class MealService {
    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {
        System.out.println("Meal validated successfully");
        return new Meal<>(plan);
    }
}

public class MealPlanGeneraor {
	public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = MealService.generateMeal(new VegetarianMeal());
        vegMeal.serve();
        Meal<KetoMeal> ketoMeal =  MealService.generateMeal(new KetoMeal());
        ketoMeal.serve();
    }
}
