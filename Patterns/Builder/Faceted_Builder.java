package Patterns.Builder;

// Using multiple builders to build up an object

class PersonImpl {
    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;

    public int annualIncome;

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

// Builder facade
class PersonImplBuilder {
    protected PersonImpl person = new PersonImpl();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public PersonImpl build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonImplBuilder {
    public PersonAddressBuilder(PersonImpl person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postcode) {
        person.postcode = postcode;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonImplBuilder {
    public PersonJobBuilder(PersonImpl person) {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.position = position;
        return this;
    }

    public PersonJobBuilder earning(Integer num) {
        person.annualIncome = num;
        return this;
    }
}

class DemoPersonImpl {
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