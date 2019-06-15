package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactRepositoryTest {

	@Autowired
	RecipeReactiveRepository recipeReactRepository;

	@Before
	public void setUp() throws Exception {
		recipeReactRepository.deleteAll().block();
	}

	@Test
	public void testRecipeSave() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setDescription("Yummy");

		recipeReactRepository.save(recipe).block();

		Long count = recipeReactRepository.count().block();

		assertEquals(Long.valueOf(1L), count);
	}
}