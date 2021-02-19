package com.ems.constants;



/**
 * 
 * @author Dev
 *
 */
public enum EmsStatusEnum {
	ADDED,
	IN_CHECK,
	APPROVED,
	ACTIVE;

	EmsStatusEnum() {
    }

    public String getStatus() {
        return this.name();
    }
    
    public static boolean isType(String type) {
    	EmsStatusEnum[] types = EmsStatusEnum.values();
        for (EmsStatusEnum t : types) {
            if (t.name().equals(type)) {
                return true;
            }
        }
        return false;
    }
    
    public static EmsStatusEnum getType(String type) {
    	EmsStatusEnum[] types = EmsStatusEnum.values();
        for (EmsStatusEnum t : types) {
            if (t.name().equals(type)) {
                return t;
            }
        }
        return null;
    }
}

