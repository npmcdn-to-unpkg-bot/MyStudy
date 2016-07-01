"use strict";
/**
 * var myAes = MyAes(key, iv);
 * var myAes = MyAes(key, iv, true);
 * @param key {String}
 * @param iv {String}
 * @param isNewInstance {boolean} true|false; def: false;
 * @returns {MyAes|*}
 * @constructor
 */
function MyAes(key, iv, isNewInstance) {
    if (!isNewInstance && MyAes.instance) {
        return MyAes.instance;
    }
    this.key = key;
    this.config = {
        iv: iv,
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
    };
    if (MyAes._initialized) {
        return MyAes.instance;
    }
    /**
     * encrypt(string)
     * @param string
     * @returns {String} encrypted string;
     */
    MyAes.prototype.encrypt = function (string) {
        var __this = this;
        var encryptedString = CryptoJS.AES.encrypt(string, __this.key,
            __this.config);
        return encryptedString.toString();
    };

    /**
     * decrypt(encryptedString)
     * @param encryptedString
     * @returns {String} decrypted string;
     */
    MyAes.prototype.decrypt = function (encryptedString) {
        var __this = this;
        var decryptedString = CryptoJS.AES.decrypt(encryptedString, __this.key,
            __this.config);
        return decryptedString.toString(CryptoJS.enc.Utf8);
    };

    MyAes._initialized = true;
    MyAes.instance = this;
}