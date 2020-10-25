package com.noryangjin.boostcourse.repository.category;

import com.noryangjin.boostcourse.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategorySupportRepository {

}
