package org.assertj.core.api

import java.util.function.Consumer


fun <T : Any> AbstractAssert<*, T>.satisfiesRequirements(requirements: (T) -> Unit): AbstractAssert<*, *> {
	return this.satisfies(requirements.toConsumer())
}

fun <E : Any, I : Iterable<E>> AbstractIterableAssert<*, I, E, *>.allSatisfyRequirements(requirements: (E) -> Unit): AbstractIterableAssert<*, *, *, *> {
	return this.allSatisfy(requirements.toConsumer())
}

private fun <T> ((T) -> Unit).toConsumer(): Consumer<T> {
	return Consumer { this(it) }
}