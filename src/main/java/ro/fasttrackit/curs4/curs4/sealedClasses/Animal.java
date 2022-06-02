package ro.fasttrackit.curs4.curs4.sealedClasses;

sealed interface Animal permits Dog, Cat, Bird, Fish {

}

sealed interface Dog extends Animal {

}

non-sealed class Terrier implements Dog {

}

class LittleTerrier extends Terrier {

}


sealed class Cat implements Animal {

}

final class CommonCat extends Cat {

}

//
record Bird(String name) implements Animal {

}


sealed interface Fish extends Animal permits Salmon {

}

sealed interface Salmon extends Fish{

}

sealed interface PinkTrout extends Salmon {

}
record Alaska(String name) implements PinkTrout{

}
final class BlackTrout implements Salmon {

}
