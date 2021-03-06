// tag::extraProperties[]
plugins {
    java
}
// end::extraProperties[]


// tag::taskProperties[]
task("myTask") {
    extra["myProperty"] = "myValue"
}

task("printTaskProperties") {
    doLast {
        println(tasks["myTask"].extra["myProperty"])
    }
}
// end::taskProperties[]


// tag::extraProperties[]

val springVersion by extra("3.1.0.RELEASE")
val emailNotification by extra { "build@master.org" }

sourceSets.all { extra["purpose"] = null }

sourceSets {
    main {
        extra["purpose"] = "production"
    }
    test {
        extra["purpose"] = "test"
    }
    create("plugin") {
        extra["purpose"] = "production"
    }
}

task("printProperties") {
    doLast {
        println(springVersion)
        println(emailNotification)
        sourceSets.matching { it.extra["purpose"] == "production" }.forEach { println(it.name) }
    }
}
// end::extraProperties[]
