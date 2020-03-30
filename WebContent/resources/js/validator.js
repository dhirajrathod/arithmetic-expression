var requiredMessage = " is Required.";
var alphaWithSpaceMessage = " should be alphabets or with space.";
var validTillLengthMessage = " should be of maximum ";
var numericMessage = " should be numeric.";
var numericWithDecimalMessage = " should be numeric or with decimal.";
var pincodeMessage = " should be numeric and of length ";
var invalidFormatMessage = " is not in valid format.";
var numericLengthMessage = " should be numeric and of length ";
var mobileNoMessage = " should be numeric and of length 10 and must start with 6 or 7 or 8 or 9";
var selectMessage = "Please select ";
var termsAndConditionMessage = "Please accept Terms & Conditions ";
var passwordMessage = "Please enter valid Password. Password should be minimum of 8 and maximum of 16 character and must contain atleast 1 Capital Alphabet,  1 Lower Alphabet, 1 Number and 1 Special Character.";
var passwordNormalMessage = "Please enter valid Password. Password should be minimum of 8 and maximum of 16 character.";
var otpMessage = "Please enter valid OTP. OTP should be of 6 digit number.";
var alphanumericWithSpace = " should be alphabets numbers or with space.";
var alphanumericWithSpaceOrDot = " should be alphabets numbers or with dot(.)";
var alphanumericWithSpaceOrAnd = " should be alphabets numbers or with and(&)";

function clearClientErrors(formName) {
    var $inputs = $('#' + formName + ' :input');
    $(".error").text("");
    $(".error").hide();
    $inputs.each(function (index) {
        if ($(this).attr('type') !== "submit" && $(this).attr('type') !== "button") {
            var errors = $("#" + $(this).attr('id') + "-error").text();
            if (errors !== null || errors.length > 0) {
                $("#" + $(this).attr('id') + "-error").text("");
                $("#" + $(this).attr('id')).parent('.form-group').removeClass('has-error');
            }
        }
    });
}

function onloadClearServerErrors() {
    $("[id*=server-error]").each(function () {
        $(this).text("");
    });
}

function onloadClearServerSuccess() {
    $("[id*=server-success]").each(function () {
        $(this).text("");
    });
}

function isFormValidated(formName) {
    var validate = false;
    var $inputs = $('#' + formName + ' :input');
    $inputs.each(function (index) {
        if ($(this).attr('type') !== "submit" && $(this).attr('type') !== "button") {
            var errors = $("#" + $(this).attr('id') + "-error").text();
            if (errors !== undefined && errors !== null && errors.length > 0) {
                $("#" + $(this).attr('id') + "-error").show();
                $("#" + $(this).attr('id')).parent('.form-group').addClass('has-error');
            } else {
                $("#" + $(this).attr('id') + "-error").hide();
                $("#" + $(this).attr('id')).parent('.form-group').removeClass('has-error');
            }
        }
    });
    $inputs.each(function (index) {
        if ($(this).attr('type') !== "submit" && $(this).attr('type') !== "button") {
            var errors = $("#" + $(this).attr('id') + "-error").text();

            if (errors !== undefined && errors !== null && errors.length > 0) {
                validate = false;
                return false;
            } else {
                validate = true;
            }
        }
    });
    return validate;
}

function required(fieldValue) {
    var required = true;
    if (fieldValue === undefined || fieldValue === null || fieldValue.length === 0) {
        required = true;
    } else {
        required = false;
    }
    return required;
}

function isPassword(fieldValue) {
    var isPasswordValid = false;
    if (fieldValue.search(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&#])[A-Za-z\d$@$!%*?&#]{8,16}$/) === 0) {
        isPasswordValid = true;
    } else {
        isPasswordValid = false;
    }
    return isPasswordValid;
}

function isPasswordNormal(fieldValue) {
    var isPasswordValid = false;
    if (fieldValue.length < 8 || fieldValue.length > 16) {
        isPasswordValid = false;
    } else {
        isPasswordValid = true;
    }
    return isPasswordValid;
}

function isEmail(fieldValue) {
    var isEmailValid = false;
    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (filter.test(fieldValue)) {
        isEmailValid = true;
    } else {
        isEmailValid = false;
    }
    return isEmailValid;
}

function isMobileNo(fieldValue) {
    var isMobileNoValid = false;
    var filter = /^\d{10}$/;
    if (fieldValue.match(filter)) {
        if (fieldValue.startsWith("6") || fieldValue.startsWith("7") || fieldValue.startsWith("8") || fieldValue.startsWith("9")) {
            isMobileNoValid = true;
        } else {
            isMobileNoValid = false;
        }
    } else {
        isMobileNoValid = false;
    }
    return isMobileNoValid;
}

function isPhoneNo(fieldValue) {
    var isPhoneNoValid = false;
    var filter = /^\d{11}$/;
    if (fieldValue.match(filter)) {
        isPhoneNoValid = true;
    } else {
        isPhoneNoValid = false;
    }
    return isPhoneNoValid;
}

function isAlphanumericWithSpace(fieldValue) {
    var isAlphanumericWithSpace = false;
    var filter = /^[a-zA-Z0-9\-\s]+$/;
    if (fieldValue.match(filter)) {
        isAlphanumericWithSpace = true;
    } else {
        isAlphanumericWithSpace = false;
    }
    return isAlphanumericWithSpace;
}

function isAlphaWithSpace(fieldValue) {
    var isAlphaWithSpace = false;
    var filter = /^[a-zA-Z\-\s]+$/;
    if (fieldValue.match(filter)) {
        isAlphaWithSpace = true;
    } else {
        isAlphaWithSpace = false;
    }
    return isAlphaWithSpace;
}

function isAlphanumeric(fieldValue) {
    var isAlphanumeric = false;
    var filter = /^[a-zA-Z0-9\-\s]+$/;
    if (fieldValue.match(filter)) {
        isAlphanumeric = true;
    } else {
        isAlphanumeric = false;
    }
    return isAlphanumeric;
}

function isAlphanumericOrWithDot(fieldValue) {
    var isAlphanumeric = false;
    var filter = /^[ A-Za-z0-9.]*$/;
    if (fieldValue.match(filter)) {
        isAlphanumeric = true;
    } else {
        isAlphanumeric = false;
    }
    return isAlphanumeric;
}

function isAlphanumericOrWithAnd(fieldValue) {
    var isAlphanumeric = false;
    var filter = /^[ A-Za-z0-9&]*$/;
    if (fieldValue.match(filter)) {
        isAlphanumeric = true;
    } else {
        isAlphanumeric = false;
    }
    return isAlphanumeric;
}

function isOTP(fieldValue) {
    var isOTPValid = false;
    var filter = /^\d{6}$/;
    if (fieldValue.match(filter)) {
        isOTPValid = true;
    } else {
        isOTPValid = false;
    }
    return isOTPValid;
}

function isPincode(fieldValue) {
    var isPincodeValid = false;
    var filter = /^\d{6}$/;
    if (fieldValue.match(filter)) {
        isPincodeValid = true;
    } else {
        isPincodeValid = false;
    }
    return isPincodeValid;
}

function isNumberValue(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

function isNumber(fieldValue) {
    var isNumber = false;
    var filter = /^[0-9]+$/;
    if (fieldValue.match(filter)) {
        isNumber = true;
    } else {
        isNumber = false;
    }
    return isNumber;
}

function isNumberWithDecimal(fieldValue) {
    var isNumber = false;
    var filter = /^\d+\.\d{0,2}$/;
    if (fieldValue.match(filter)) {
        isNumber = true;
    } else {
        isNumber = false;
    }
    return isNumber;
}

function isValidTillLength(fieldValue, valLength) {
    var isValidTillLength = false;
    if (fieldValue.length <= valLength) {
        isValidTillLength = true;
    } else {
        isValidTillLength = false;
    }
    return isValidTillLength;
}