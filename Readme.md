# Blockchain Utilities - Java & Kotlin Library

Blockchain Utilities is a Java/Kotlin library that provides a set of common utilities for working with blockchain networks.
Our current functionality focuses on address validation for Ethereum and Bitcoin across multiple networks.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To use this library in your Java/Kotlin project, you need to have either Java/Kotlin environment set up on your machine.

### Installation

To include this library in your project, add the following to your `build.gradle` or `build.gradle.kts` file:

```gradle
dependencies {
    implementation 'io.bityagi.blockchain.utils:0.0.1-SNAPSHOT'
}
```

## Usage
Here's a simple example of how to use the library to validate Ethereum and Bitcoin addresses:
```java

import org.bityagi.blockchain.utils.AddressValidator;

class Main {
    public static void main(String[] args) {
        AddressValidator validator = new AddressValidator();

        // validate Ethereum address
        boolean isValidEthereumAddress = validator.validateEthereumAddress("0x...", "mainnet");

        // validate Bitcoin address
        boolean isValidBitcoinAddress = validator.validateBitcoinAddress("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "mainnet");
        
        System.out.println(isValidEthereumAddress);
        System.out.println(isValidBitcoinAddress);
    }
}
```

## Running the tests
Tests are written using JUnit. You can run them via the command line with Gradle:
```shell
./gradlew test
```

## Contributing
Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning
We use [SemVer](https://semver.org/) for versioning. For the versions available, see the tags on this repository.

## License
This project is licensed under the MIT License, reference the [LICENSE.md](LICENSE.md) file for details.
