package menu.service;import menu.domain.Category;import menu.repository.CategoryRepository;import menu.utils.InitData;public class CategoryService {    private final CategoryRepository categoryRepository;    public CategoryService() {        this.categoryRepository = new CategoryRepository();    }    public void initCategory() {        for (String category : InitData.categories) {            categoryRepository.addCategory(new Category(category));        }    }}