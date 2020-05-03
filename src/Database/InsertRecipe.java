package Database;

import Recipe.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecipe extends DbAccess{

    public InsertRecipe(String path) {
        super(path);
    }

    public void insert(Recipe recipe) {
        insertRecipe(recipe);
        insertIngredients(recipe);
        insertDirections(recipe);
    }

    private void insertRecipe (Recipe recipe) {
        String title = recipe.getTitle();
        String course = recipe.getCourse();
        String category = recipe.getCategory();
        String image = recipe.getImgSrc();

        String sql = "INSERT INTO recipes(title,course,category,imgSRC) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, course);
            pstmt.setString(3, category);
            pstmt.setString(4, image);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertIngredients (Recipe recipe) {

    }

    private void insertDirections (Recipe recipe) {

    }
}
