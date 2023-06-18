package io.digitalasset.utils.address

import org.bitcoinj.core.Address
import org.bitcoinj.core.AddressFormatException
import org.bitcoinj.params.MainNetParams
import org.bitcoinj.params.TestNet3Params
import org.web3j.utils.Numeric
import org.web3j.crypto.Keys

class AddressValidator {

    fun validateAddress(address: String, network: String, coin: String): Boolean {
        when (coin.toLowerCase()) {
            "eth" -> return validateEthereumAddress(address, network)
            "btc" -> return validateBitcoinAddress(address, network)
        }
        return validateEthereumAddress(address, network) || validateBitcoinAddress(address, network)
    }

    // Function to validate Ethereum addresses
    fun validateEthereumAddress(address: String, network: String): Boolean {
        return try {
            if (address.length != 42 || !address.startsWith("0x")) {
                return false
            }
            val cleanAddress = Numeric.cleanHexPrefix(address)
            val checksumAddress = Numeric.prependHexPrefix(Keys.toChecksumAddress(cleanAddress))
            when (network.toLowerCase()) {
                "mainnet", "goerli", "sepolia" -> address == checksumAddress
                else -> false
            }
        } catch (e: Exception) {
            false
        }
    }

    fun validateBitcoinAddress(address: String, network: String): Boolean {
        val params = when (network.toLowerCase()) {
            "mainnet" -> MainNetParams.get()
            "testnet", "regtest" -> TestNet3Params.get()
            else -> null
        }

        return try {
            params?.let {
                Address.fromString(it, address)
                true
            } ?: false
        } catch (e: AddressFormatException) {
            false
        }
    }

}