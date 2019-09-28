package marmitonLike;

import java.util.HashMap;

import fr.clement.engine.Engine;
import fr.clement.entities.Ingredient;
import fr.clement.entities.IngredientWrapper;
import fr.clement.entities.Recette;
import fr.clement.view.FxView;
import fr.clement.view.MarmitonFrame;

public class Main {
	public static void main(String[] args) {
		
		//Engine engine=new Engine();
		//engine.initApp();
		//engine.addNewReceipe(addReceipeToTest());
		
		//MarmitonFrame mf=new MarmitonFrame();
		//mf.setVisible(true);
		FxView fx=new FxView();
		fx.launch(FxView.class,null);
	}
	
	public static Recette addReceipeToTest() {
		Recette recette=new Recette("testtt","testDescription");
		IngredientWrapper iw=new IngredientWrapper();
		HashMap<String, String> dictionnary=new HashMap<String,String>();
		dictionnary.put("kcal", "0");
		dictionnary.put("fibre", "0");
		dictionnary.put("glucide", "0");
		dictionnary.put("lipide", "0");
		dictionnary.put("portion_moyenne", "0");
		Ingredient ingredient=new Ingredient("test_ingredient","4.0",dictionnary);
		iw.addIngredient(ingredient);
		recette.setIngredientWrapper(iw);
		
		return recette;
	}
}
