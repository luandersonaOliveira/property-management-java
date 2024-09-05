package Enum;

public enum EnumLeaseException {
    // INVALID
    LeaseInvalidIndex,
    LeaseInvalidStartOrEndDate,
    LeaseInvalidCpfEqual,
    LeaseInvalidValue,
    
    // NO REGISTERED
    LeaseInvalid,
    LeaseNoRegistered,
    LeaseInvalidRegistered;
}
