package com.noryangjin.boostcourse.repository.displayInfo;

import com.noryangjin.boostcourse.domain.DisplayInfo;
import com.noryangjin.boostcourse.domain.QCategory;
import com.noryangjin.boostcourse.domain.QDisplayInfo;
import com.noryangjin.boostcourse.domain.QProduct;
import com.noryangjin.boostcourse.dto.DisplayInfoDTO;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class DisplayInfoSupportRepositoryImpl extends QuerydslRepositorySupport implements DisplayInfoSupportRepository{

    public DisplayInfoSupportRepositoryImpl() {super(DisplayInfo.class);}

    @Override
    public List<DisplayInfo> listCategoryId(Long categoryId, Pageable pageable) {

        final QCategory category = QCategory.category;
        final QProduct product = QProduct.product;
        final QDisplayInfo displayInfo = QDisplayInfo.displayInfo;

        final JPQLQuery<DisplayInfo> query;

        query = from(displayInfo)
                .where(displayInfo.product_id.in
                        (
                                (from(product)
                                        .select(product.id)
                                        .where(product.category_id.eq(categoryId)))
                        )
                );

        List<DisplayInfo> list = getQuerydsl().applyPagination(pageable, query).fetch();

        return list;
    }
}
