2022-08-01 Christoph Knabe

# Using Constructor Injection for Prohibiting Cyclic Type dependencies

In the Java/Spring world there is a discussion, which kind of dependency injection to use.

In the article [Spring Dependency Injection – Field vs Setter vs Constructor Injection](https://www.javacodegeeks.com/2019/02/field-setter-constructor-injection.html) this topic is discussed and some scenarios are explained. In short the Pros:

* **Field Injection**: Shortest notation
* **Setter Injection**: Clear names even if there are many dependencies to be injected
* **Constructor Injection**: Object will be completely initialized. Enables final fields, by which you can make the object thread-safe.

Spring nowadays simplifies the secure constructor injection by the possibility to place the `@Autowired` annotation before the constructor.

## Detecting Type Cycles

Constructor Injection has the advantage, that you can construct only completely. If you make all fields **final**, you cannot construct an incomplete object. So the compiler prohibits to create a type dependency cycle. You simply cannot compile `final A a = new A(new B(a));`

## Eliminating Type Cycles

This source code example of the types for a directory/file hierarchy shows in package [cyclic](cyclic) the first traditional form, where there is a type cycle between `Directory` and `Entry`. The `Directory` knows its `Entry` objects, the `Entry` knows its parent `Directory`.

The revised types in package `partialOrder` break up the type cycle by introducing an interface `HasPath` for that, what the `Entry` needs from its parent `Directory`, whereas the `Directory` can further hold a collection of its child `Entry` objects.

This is the way to remove type dependency cycles.

