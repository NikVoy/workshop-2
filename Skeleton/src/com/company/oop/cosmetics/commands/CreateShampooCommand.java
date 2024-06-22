package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.core.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.enums.GenderType;
import com.company.oop.cosmetics.models.enums.UsageType;
import com.company.oop.cosmetics.utils.ParsingHelpers;
import com.company.oop.cosmetics.utils.ValidationHelpers;
import java.util.List;

public class CreateShampooCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brandName = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ProductImpl.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3).toUpperCase());
        int millilitres = ParsingHelpers.tryParseInt(parameters.get(4), ProductImpl.INVALID_MILLILITRES);
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5).toUpperCase());
        return createShampoo(name, brandName, price, genderType, millilitres, usageType);
    }

    private String createShampoo(String name, String brandName, double price, GenderType genderType,
                                 int millilitres, UsageType usageType) {
        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException(String.format(ProductImpl.PRODUCT_NAME_ALREADY_EXISTS, "Shampoo", name));
        }

        cosmeticsRepository.createShampoo(name, brandName, price, genderType, millilitres, usageType);

        return String.format(ProductImpl.PRODUCT_CREATED, "Shampoo", name);
    }
}
