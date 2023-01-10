package com.example.examserver.controller.exam;


import com.example.examserver.model.exam.Category;
import com.example.examserver.service.exam.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


//    add Category
    @PostMapping("/")
    public ResponseEntity<?>addCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }


//    get category by Id

    @GetMapping("/{cId}")
    public ResponseEntity<?>getCategory(@PathVariable long cId){
        return new ResponseEntity<>(categoryService.getCategoryById(cId), HttpStatus.OK);
    }

//    get All category

    @GetMapping("/")
    public ResponseEntity<?>getAllCategory(){
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }



//    Update category
    @PutMapping("/")
    public ResponseEntity<?>updateCategory(@RequestBody Category category){
        return  new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.OK);
    }


//    Delete Category
    @DeleteMapping("/{cId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long cId){
        categoryService.deleteCategory(cId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
