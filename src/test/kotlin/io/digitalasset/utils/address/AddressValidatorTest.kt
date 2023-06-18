package io.digitalasset.utils.address

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AddressValidatorTest {

    private val validator = AddressValidator()

    @Test
    fun testValidateEthereumAddressMainnet() {
        // Test case: Valid Ethereum address and mainnet network
        assertTrue(validator.validateEthereumAddress("0x742d35Cc6634C0532925a3b844Bc454e4438f44e", "mainnet"))

    }

    @Test
    fun testValidateEthereumAddressGoerli() {
        // Test case: Valid Ethereum address and goerli network
        assertTrue(validator.validateEthereumAddress("0x742d35Cc6634C0532925a3b844Bc454e4438f44e", "goerli"))
    }

    @Test
    fun testValidateEthereumAddressSepolia() {
        // Test case: Valid Ethereum address and sepolia network
        assertTrue(validator.validateEthereumAddress("0x742d35Cc6634C0532925a3b844Bc454e4438f44e", "sepolia"))
    }

    @Test
    fun testValidateEthereumAddressMainnetBadAddress() {
        // Test case: Invalid Ethereum address and mainnet network
        assertFalse(validator.validateEthereumAddress("0x123456", "mainnet"))
    }

    @Test
    fun testValidateEthereumAddressUnsupportedNetwork() {
        // Test case: Valid Ethereum address but unsupported Ethereum network
        assertFalse(validator.validateEthereumAddress("0x742d35Cc6634C0532925a3b844Bc454e4438f44e", "unsupportedNetwork"))
    }

    @Test
    fun testValidateBitcoinAddressMainnet() {
        // Test case: Valid Bitcoin address and mainnet network
        assertTrue(validator.validateBitcoinAddress("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "mainnet"))
    }
    @Test
    fun testValidateBitcoinAddressTestnet() {
        // Test case: Valid Bitcoin address and testnet network
        assertTrue(validator.validateBitcoinAddress("2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc", "testnet"))
    }

    @Test
    fun testValidateBitcoinAddressRegtest() {
        // Test case: Valid Bitcoin address and regtest network
        assertTrue(validator.validateBitcoinAddress("2MzQwSSnBHWHqSAqtTVQ6v47XtaisrJa1Vc", "regtest"))
    }

    @Test
    fun testValidateBitcoinAddressMainnetBadAddress() {
        // Test case: Invalid Bitcoin address and mainnet network
        assertFalse(validator.validateBitcoinAddress("123456", "mainnet"))
    }

    @Test
    fun testValidateBitcoinAddressUnsupportedNetwork() {
        // Test case: Valid Bitcoin address but unsupported Bitcoin network
        assertFalse(validator.validateBitcoinAddress("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "unsupportedNetwork"))
    }

}