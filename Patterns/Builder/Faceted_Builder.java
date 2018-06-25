package Patterns.Builder;

// Using multiple builders to build up an object

/**
 * PersonImpl class
 */
class PersonImpl {
    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;

    public int annualIncome;

    /**
     * Returns String representation of PersonImpl instance
     * @return String
     */
    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome='" + annualIncome + '\'' +
                '}';
    }
}

/**
 * PersonImpl Builder Class
 */
class PersonImplBuilder {
    // Create a PersonImpl instance
    protected PersonImpl person = new PersonImpl();

    /**
     * This method returns a PersonAddressBuilder instance
     * which can be used to set companyName, position and annualIncome
     * fields of the PersonImpl instance
     * @return PersonAddressBuilder instance
     */
    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    /**
     * This method returns a PersonAddressBuilder instance
     * which can be used to set streetAddress, postcode and city
     * fields of the PersonImpl instance
     * @return PersonJobBuilder instance
     */
    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    /**
     * This method returns a PersonImpl instance
     * @return PersonImpl instance
     */
    public PersonImpl build() {
        return person;
    }
}

/**
 * This class implements methods to set a PersonImpl instance's
 * streetAddress, postCode and city fields
 */
class PersonAddressBuilder extends PersonImplBuilder {

    /**
     * This method creates a PersonAddressBuilder instance
     * @param person PersonImpl instance
     */
    public PersonAddressBuilder(PersonImpl person) {
        this.person = person;
    }

    /**
     * This method sets the streetAddress field on PersonImpl instance
     * @param streetAddress {String}
     * @return PersonAddressBuilder instance
     */
    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    /**
     * This method sets the postcode field on PersonImpl instance
     * @param postcode {String}
     * @return PersonAddressBuilder instance
     */
    public PersonAddressBuilder withPostCode(String postcode) {
        person.postcode = postcode;
        return this;
    }

    /**
     * This method sets the city field on PersonImpl instance
     * @param city {String}
     * @return PersonAddressBuilder instance
     */
    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }
}

/**
 * This class implements methods to set a PersonImpl instance's
 * companyName, position and annualIncome fields
 */
class PersonJobBuilder extends PersonImplBuilder {

    /**
     * This method creates a PersonJobBuilder instance
     * @param person PersonImpl instance
     */
    public PersonJobBuilder(PersonImpl person) {
        this.person = person;
    }

    /**
     * This method sets the companyName field on PersonImpl instance
     * @param companyName {String}
     * @return PersonAddressBuilder instance
     */
    public PersonJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    /**
     * This method sets the position field on PersonImpl instance
     * @param position {String}
     * @return PersonJobBuilder instance
     */
    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    /**
     * This method sets the annualIncome field on PersonImpl instance
     * @param num {String}
     * @return PersonJobBuilder instance
     */
    public PersonJobBuilder earning(Integer num) {
        person.annualIncome = num;
        return this;
    }
}

/**
 * Demonstrates Facade Builder example
 */
class DemoPersonImpl {
    /**
     * This is the main method which demonstrates Facade Builder example.
     * @param args Unused
     */
    public static void main(String[] args) {
        PersonImplBuilder pb = new PersonImplBuilder();
        PersonImpl person = pb
                .lives()
                    .at("123 London Road")
                    .in("London")
                    .withPostCode("SW12BC")
                .works()
                    .at("Google")
                    .asA("Developer")
                    .earning(123000)
                .build();

        System.out.println(person);

    }
}