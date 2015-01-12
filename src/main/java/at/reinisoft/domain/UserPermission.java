package at.reinisoft.domain;


public enum UserPermission {

    /** Cannot determine right Permission for an object, so return this permission prevent the access for safety. */
    NEVER_ALLOWED,

    /** Show Edit Buttons in Global Search results (e.g.: multi delete). */
    PERM_GLOBAL_SEARCH_EDIT,

    /** View Global Search results. */
    PERM_GLOBAL_SEARCH_VIEW,

    /** Edit allowances. */
    PERM_ALLOWANCES_EDIT,

    /** View allowances. */
    PERM_ALLOWANCES_VIEW,

    /** Edit bundles. */
    PERM_BUNDLES_EDIT,

    /** View bundles. */
    PERM_BUNDLES_VIEW,

    /** Edit change products. */
    PERM_CHANGE_PRODUCTS_EDIT,

    /** View change products. */
    PERM_CHANGE_PRODUCTS_VIEW,

    /** Edit dealers. */
    PERM_DEALER_EDIT,

    /** View dealers. */
    PERM_DEALER_VIEW,

    /** Refresh Cache. */
    PERM_DEALER_PERMISSION_CACHE_UPDATE,

    /** Edit dealer permissions. */
    PERM_DEALER_PERMISSION_EDIT,

    /** View dealer permissions. */
    PERM_DEALER_PERMISSION_VIEW,

    /** Start transfer of dealer permissions to TFC. */
    PERM_DEALER_PERMISSION_TRANSFER,

    /** Import of dealer permissions as CSV. */
    PERM_DEALER_PERMISSION_IMPORT,

    /** Export of dealer permissions as CSV. */
    PERM_DEALER_PERMISSION_EXPORT,

    /** View PolicySets. */
    PERM_POLICY_SET_VIEW,

    /** Edit PolicySets. */
    PERM_POLICY_SET_EDIT,

    /** View PolicyRules. */
    PERM_POLICY_RULE_VIEW,

    /** Edit PolicyRules. */
    PERM_POLICY_RULE_EDIT,

    /** Edit discounts. */
    PERM_DISCOUNTS_EDIT,

    /** View discounts. */
    PERM_DISCOUNTS_VIEW,

    /** Edit distribution channels. */
    PERM_DISTRIBUTION_CHANNELS_EDIT,

    /** View distribution channels. */
    PERM_DISTRIBUTION_CHANNELS_VIEW,

    /** View and use the import site. */
    PERM_IMPORT_VIEW,

    /** View and use the export site. */
    PERM_EXPORT_VIEW,

    /** View import logs. */
    PERM_IMPORT_LOGGING_VIEW,

    /** Edit market segments. */
    PERM_MARKET_SEGMENTS_EDIT,

    /** View market segments. */
    PERM_MARKET_SEGMENTS_VIEW,

    /** Edit prices. */
    PERM_PRICES_EDIT,

    /** View prices. */
    PERM_PRICES_VIEW,

    /** Edit product change groups. */
    PERM_PRODUCT_CHANGE_GROUPS_EDIT,

    /** View product change groups. */
    PERM_PRODUCT_CHANGE_GROUPS_VIEW,

    /** Edit product groups. */
    PERM_PRODUCT_GROUPS_EDIT,

    /** View product groups. */
    PERM_PRODUCT_GROUPS_VIEW,

    /** Edit product specification characteristic values. */
    PERM_PRODUCT_SPECIFICATION_CHARACTERISTIC_VALUES_EDIT,

    /** View product specification characteristic values. */
    PERM_PRODUCT_SPECIFICATION_CHARACTERISTIC_VALUES_VIEW,

    /** Edit product specification characteristics. */
    PERM_PRODUCT_SPECIFICATION_CHARACTERISTICS_EDIT,

    /** View product specification characteristics. */
    PERM_PRODUCT_SPECIFICATION_CHARACTERISTICS_VIEW,

    /** Edit product specification types. */
    PERM_PRODUCT_SPECIFICATION_TYPES_EDIT,

    /** View product specification types. */
    PERM_PRODUCT_SPECIFICATION_TYPES_VIEW,

    /** Edit product specifications. */
    PERM_PRODUCT_SPECIFICATIONS_EDIT,

    /** View product specifications. */
    PERM_PRODUCT_SPECIFICATIONS_VIEW,

    /** Edit product types. */
    PERM_PRODUCT_TYPES_EDIT,

    /** View product types. */
    PERM_PRODUCT_TYPES_VIEW,

    /** Edit product offering type groups. */
    PERM_PRODUCT_TYPE_GROUPS_EDIT,

    /** View product offering type groups. */
    PERM_PRODUCT_TYPE_GROUPS_VIEW,

    /** Edit simple products. */
    PERM_PRODUCTS_EDIT,

    /** View simple products. */
    PERM_PRODUCTS_VIEW,

    /** Edit promotions. */
    PERM_PROMOTIONS_EDIT,

    /** View promotions. */
    PERM_PROMOTIONS_VIEW,

    /** Edit service specifications. */
    PERM_SERVICE_SPECIFICATIONS_EDIT,

    /** View service specifications. */
    PERM_SERVICE_SPECIFICATIONS_VIEW,

    /** Edit tasks. */
    PERM_TASK_EDIT,

    /** View task logs. */
    PERM_TASK_LOGGING_VIEW,

    /** View tasks. */
    PERM_TASK_VIEW,

    /** Edit terms. */
    PERM_TERMS_EDIT,

    /** View terms. */
    PERM_TERMS_VIEW,

    /** Edit term values. */
    PERM_TERM_VALUES_EDIT,

    /** View term values. */
    PERM_TERM_VALUES_VIEW,

    /** Edit voucher set. */
    PERM_VOUCHER_SET_EDIT,

    /** View voucher set. */
    PERM_VOUCHER_SET_VIEW,

    /** Create, edit and view users. */
    PERM_USERADMINISTRATION,

    /** Create, edit and view billing references. */
    PERM_BILLING_REFERENCES_EDIT,

    /** View billing references. */
    PERM_BILLING_REFERENCES_VIEW,

    /** Create, edit and view billing commitments. */
    PERM_BILLING_COMMITMENTS_EDIT,

    /** View billing commitments. */
    PERM_BILLING_COMMITMENTS_VIEW,

    /** Create, edit and view ADX Technical Parameters. */
    PERM_ADX_PARAM_EDIT,

    /** View ADX Technical Parameters. */
    PERM_ADX_PARAM_VIEW,

    /** View Product Specification Characteristic Groups. */
    PERM_PRODUCT_SPEC_CHARACTERISTICS_GROUPS_VIEW,

    /** Create, edit and view Product Specification Characteristic Groups. */
    PERM_PRODUCT_SPEC_CHARACTERISTICS_GROUPS_EDIT,

    /** View Customer Facing Service Specifications. */
    PERM_CUSTOMER_FACING_SERVICE_SPECS_VIEW,

    /** Create, edit and view Customer Facing Service Specifications. */
    PERM_CUSTOMER_FACING_SERVICE_SPECS_EDIT,

    /** View Service Spec Characteristics. */
    PERM_SERVICE_SPEC_CHARACTERISTICS_VIEW,

    /** Create, edit and view Service Spec Characteristics. */
    PERM_SERVICE_SPEC_CHARACTERISTICS_EDIT,

    /** View Service Spec Characteristic Values. */
    PERM_SERVICE_SPEC_CHARACTERISTIC_VALUES_VIEW,

    /** Create, edit and view Service Spec Characteristic Values. */
    PERM_SERVICE_SPEC_CHARACTERISTIC_VALUES_EDIT,

    /** View the Change Log. */
    PERM_CHANGE_LOG_VIEW,

    /** View the Delivery Filter Configuration. */
    PERM_SERVICE_CONFIG_VIEW,

    /** View the Offering Actions. */
    PERM_OFFERING_ACTIONS_VIEW,

    /** Edit the Offering Actions. */
    PERM_OFFERING_ACTIONS_EDIT,

    /** View the Offering Processes. */
    PERM_OFFERING_PROCESSES_VIEW,

    /** Edit the Offering Processes. */
    PERM_OFFERING_PROCESSES_EDIT,

    /** Edit the Offering Processes. */
    PERM_DELIVERY_LOGGING_VIEW,

}
