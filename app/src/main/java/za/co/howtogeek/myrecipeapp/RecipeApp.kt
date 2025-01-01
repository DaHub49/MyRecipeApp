package za.co.howtogeek.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoryState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
        // RecipeScreen:
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(
                viewState = viewState,
                navigateToDetail = {
                // This is responsible for passing data from the current screen to the detail screen.
                // It utilizes the savedStateHandle, which is a component of the Compose navigation framework:
               navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
               navController.navigate(Screen.DetailScreen.route) //"recipeScreen"
            } )
        }

        // DetailScreen:
        composable(route = Screen.DetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("category") ?: Category("", "", "", "")
            CategoryDetailScreen(category)
        }

    }
}