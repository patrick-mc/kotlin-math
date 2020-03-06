package com.github.patrick.math

import kotlin.math.abs
import kotlin.random.Random.Default.nextDouble

@Suppress("unused", "MemberVisibilityCanBePrivate")

/**
 * The object 'MathHelper' contains methods for performing basic
 * numeric operations missing at 'kotlin.math' such as angle conversion,
 * cube root, random double, exact calculation, floor calculation, and
 * common divisor/multiple.
 *
 * Most of the codes are inspired by 'java.lang.Math', and some of
 * the codes simply call the equivalent method in 'java.lang.Math'.
 *
 * These codes are for ease of use when writing kotlin-based codes.
 * Accuracy of the floating-point is not 100%, so be careful when using
 * these codes.
 *
 * Hope these codes help you.
 *
 * @author PatrickKR
 */
object MathHelper {
    /**
     * The [Double] value that is closer than any other to 'e',
     * the base of the natural logarithm.
     */
    const val E = 2.71828182845904523536028747135266249775724709369995

    /**
     * The [Double] value that is closer than any other to 'pi'
     * the ratio of a circle's circumference to its diameter.
     */
    const val PI = 3.14159265358979323846264338327950288419716939937510

    /**
     * Converts an angle measured in degrees to an approximately
     * equivalent angle measured in radians.
     *
     * @param   degrees   an angle, in degrees
     * @return  the measurement of the angle in radians.
     */
    fun toRadians(degrees: Double) = degrees * PI / 180

    /**
     * Converts an angle measured in radians to an approximately
     * equivalent angle measured in degrees.
     *
     * @param   radians   an angle, in radians
     * @return  the measurement of the angle in degrees.
     */
    fun toDegrees(radians: Double) = radians * 180 / PI

    /**
     * Returns the cube root of a [Double] value.
     *
     * @param   a   a value.
     * @return  the cube root of 'a'
     */
    fun cbrt(a: Double): Double = Math.cbrt(a)

    /**
     * Returns a [Double] value pseudorandomly with a positive sign,
     * greater than or equal to '0.0' and less than '1.0'.
     *
     * @return  a pseudorandom [Double] greater than or equal
     *          to '0.0' and less than '1.0'
     */
    fun random() = nextDouble()

    /**
     * Returns the sum of its arguments,
     * throwing an exception if the result overflows an [Int].
     *
     * @param   x   the first value
     * @param   y   the second value
     * @return  the result
     * @throws  ArithmeticException if the result overflows an int
     */
    fun addExact(x: Int, y: Int) = Math.addExact(x, y)

    /**
     * Returns the sum of its arguments,
     * throwing an exception if the result overflows a [Long].
     *
     * @param   x   the first value
     * @param   y   the second value
     * @return  the result
     * @throws  ArithmeticException if the result overflows a long
     */
    fun addExact(x: Long, y: Long) = Math.addExact(x, y)

    /**
     * Returns the difference of the arguments,
     * throwing an exception if the result overflows an [Int].
     *
     * @param   x   the first value
     * @param   y   the second value to subtract from the first value
     * @return  the result
     * @throws  ArithmeticException if the result overflows an int
     */
    fun subtractExact(x: Int, y: Int) = Math.subtractExact(x, y)

    /**
     * Returns the difference of the arguments,
     * throwing an exception if the result overflows a [Long].
     *
     * @param   x   the first value
     * @param   y   the second value to subtract from the first value
     * @return  the result
     * @throws  ArithmeticException if the result overflows a long
     */
    fun subtractExact(x: Long, y: Long) = Math.subtractExact(x, y)

    /**
     * Returns the product of the arguments,
     * throwing an exception if the result overflows an [Int].
     *
     * @param   x   the first value
     * @param   y   the second value
     * @return  the result
     * @throws  ArithmeticException if the result overflows an int
     */
    fun multiplyExact(x: Int, y: Int) = Math.multiplyExact(x, y)

    /**
     * Returns the product of the arguments,
     * throwing an exception if the result overflows a [Long].
     *
     * @param   x   the first value
     * @param   y   the second value
     * @return  the result
     * @throws  ArithmeticException if the result overflows a long
     */
    fun multiplyExact(x: Long, y: Long) = Math.multiplyExact(x, y)

    /**
     * Returns the argument incremented by one,
     * throwing an exception if the result overflows an [Int].
     *
     * @param   a   the value to increment
     * @return  the result
     * @throws  ArithmeticException if the result overflows an [Int]
     */
    fun incrementExact(a: Int) = Math.incrementExact(a)

    /**
     * Returns the argument incremented by one,
     * throwing an exception if the result overflows a [Long].
     *
     * @param   a   the value to increment
     * @return  the result
     * @throws  ArithmeticException if the result overflows a [Long]
     */
    fun incrementExact(a: Long) = Math.incrementExact(a)

    /**
     * Returns the argument decremented by one,
     * throwing an exception if the result overflows an [Int].
     *
     * @param   a   the value to decrement
     * @return  the result
     * @throws  ArithmeticException if the result overflows an [Int]
     */
    fun decrementExact(a: Int) = Math.decrementExact(a)

    /**
     * Returns the argument decremented by one,
     * throwing an exception if the result overflows a [Long].
     *
     * @param   a   the value to decrement
     * @return  the result
     * @throws  ArithmeticException if the result overflows a [Long]
     */
    fun decrementExact(a: Long) = Math.decrementExact(a)

    /**
     * Returns the negation of the argument,
     * throwing an exception if the result overflows an [Int].
     *
     * @param   a   the value to negate
     * @return  the result
     * @throws  ArithmeticException if the result overflows an [Int]
     */
    fun negateExact(a: Int) = Math.negateExact(a)

    /**
     * Returns the negation of the argument,
     * throwing an exception if the result overflows a [Long].
     *
     * @param   a   the value to negate
     * @return  the result
     * @throws  ArithmeticException if the result overflows a [Long]
     */
    fun negateExact(a: Long) = Math.negateExact(a)

    /**
     * Returns the value of the [Long] argument,
     * throwing an exception if the value overflows an [Int].
     *
     * @param   a   the long value
     * @return  the argument as an [Int]
     * @throws  ArithmeticException if 'a' overflows an [Int]
     */
    fun toIntExact(a: Long) = Math.toIntExact(a)

    /**
     * Returns the largest (closest to positive infinity)
     * [Int] value that is less than or equal to the algebraic quotient.
     *
     * @param   x   the dividend
     * @param   y   the divisor
     * @return  the largest (closest to positive infinity) [Int] value
     *          that is less than or equal to the algebraic quotient.
     * @throws  ArithmeticException if the divisor 'y' is zero
     */
    fun floorDiv(x: Int, y: Int) = Math.floorDiv(x, y)

    /**
     * Returns the largest (closest to positive infinity)
     * [Long] value that is less than or equal to the algebraic quotient.
     *
     * @param   x   the dividend
     * @param   y   the divisor
     * @return  the largest (closest to positive infinity) [Long] value
     *          that is less than or equal to the algebraic quotient.
     * @throws  ArithmeticException if the divisor 'y' is zero
     */
    fun floorDiv(x: Long, y: Long) = Math.floorDiv(x, y)

    /**
     * Returns the floor modulus of the [Int] arguments.
     *
     * @param   x   the dividend
     * @param   y   the divisor
     * @return  the floor modulus 'x - (floorDiv(x, y) * y)'
     * @throws  ArithmeticException if the divisor 'y' is zero
     */
    fun floorMod(x: Int, y: Int) = Math.floorMod(x, y)

    /**
     * Returns the floor modulus of the [Long] arguments.
     *
     * @param   x   the dividend
     * @param   y   the divisor
     * @return  the floor modulus 'x - (floorDiv(x, y) * y)'
     * @throws  ArithmeticException if the divisor 'y' is zero
     */
    fun floorMod(x: Long, y: Long) = Math.floorMod(x, y)

    /**
     * Returns greatest common divisor.
     *
     * @param   x   the first number, in int
     * @param   y   the second number, in int
     * @return  the greatest common divisor of 'x' and 'y'
     * @throws  ArithmeticException if 'x' or 'y' is negative value
     */
    fun gcd(x: Int, y: Int): Int {
        var int1 = x
        var int2 = y
        if (int1 < 0 || int2 < 0) throw ArithmeticException("negative int")
        if (int1 == 0 || int2 == 0) return abs(int1 - int2)
        while (int1 % int2 != 0) {
            val remainder = int1 % int2
            int1 = int2
            int2 = remainder
        }
        return int2
    }

    /**
     * Gets the greatest common divisor of the int array.
     *
     * @param   ints  an array, contains numbers in int
     * @return  the greatest common divisor of the 'ints'
     * @throws  ArithmeticException if 'ints' contains negative value
     */
    fun gcd(ints: IntArray): Int {
        var result = ints[0]
        ints.forEach {
            try { result = gcd(result, it)
            } catch (e: ArithmeticException) { throw e }
        }
        return result
    }

    /**
     * Returns least common multiple.
     *
     * @param   x   the first number, in int
     * @param   y   the second number, in int
     * @return  the greatest common divisor of the two numbers
     * @throws  ArithmeticException if 'x' or 'y' contains negative value
     */
    fun lcm(x: Int, y: Int): Int {
        if (x < 0 || y < 0) throw ArithmeticException("negative int")
        try { return x * y / gcd(x, y)
        } catch (e: ArithmeticException) { throw e}
    }

    /**
     * Gets the least common multiple of the int array.
     *
     * @param   ints  an array, contains numbers in int
     * @return  the least common multiple of the 'ints'
     * @throws  ArithmeticException if 'ints' contains negative value
     */
    fun lcm(ints: IntArray): Int {
        var result = ints[0]
        ints.forEach {
            try { result = lcm(result, it)
            } catch (e: ArithmeticException) { throw e }
        }
        return result
    }
}