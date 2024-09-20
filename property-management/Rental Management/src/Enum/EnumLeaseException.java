package Enum;

public enum EnumLeaseException {
    // VALID
    LeaseAddedSuccessfully,
    LeaseRemovedSuccessfully,
    LeaseChangedSuccessfully,

    // INVALID
    LeaseInvalidIndex,
    LeaseInvalidStartOrEndDate,
    LeaseInvalidValue,
    
    // NO REGISTERED
    LeaseInvalid,
    LeaseNotUpdated,
    LeaseNoRegistered,
    TenantNotAddedToProperty,
    LandlordNotAddedToProperty, 
    LandlordAndTenantHaveTheSameCPF;
}
