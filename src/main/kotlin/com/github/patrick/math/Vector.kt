/*
 * Copyright (c) 2019 Noonmaru
 *
 * Licensed under the General Public License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/gpl-2.0.php
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * Copyright (C) 2020 PatrickKR
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * Contact me on <mailpatrickkr@gmail.com>
 */

package com.github.patrick.math

import com.github.patrick.math.MathHelper.toRadians
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

@Suppress("unused", "MemberVisibilityCanBePrivate")

/**
 * The 'Vector' class is a useful utility to create Vectors, which can
 * set, calculate, rotate, zero, randomize, normalize, measure, and compare
 * simply using the methods.
 *
 * You can simply create new Vector by 'Vector(x, y, z)'.
 *
 * The codes are mostly from Noonmaru's Math library, and the following
 * codes are mostly just translated codes from java to kotlin.
 *
 * I just made a little modification and added some comments for ease of use.
 *
 * Hope these codes help you.
 *
 * @author Patrick
 */
class Vector(var x: Double, var y: Double, var z: Double) {
    /**
     * Sets 'Vector''s (x, y, z) value.
     *
     * @param   x   [Double] value for [Vector.x]
     * @param   y   [Double] value for [Vector.y]
     * @param   z   [Double] value for [Vector.z]
     * @return  the 'Vector' itself after setting values
     */
    fun set(x: Double, y: Double, z: Double): Vector {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    /**
     * Sets 'Vector''s (x, y, z) value.
     *
     * @param   double  [Double] value to set all 3-axis
     * @result  the 'Vector' itself after setting values
     */
    fun set(double: Double) = set(double, double, double)

    /**
     * Sets 'Vector''s (x, y, z) value.
     *
     * @param   vector  'Vector' to get (x, y, z) values to set all 3-axis
     * @result  the 'Vector' itself after setting values
     */
    fun set(vector: Vector) = set(vector.x, vector.y, vector.z)

    /**
     * Adds (x, y, z) values to 'Vector'.
     *
     * @param   x   [Double] value to add to [Vector.x]
     * @param   y   [Double] value to add to [Vector.y]
     * @param   z   [Double] value to add to [Vector.z]
     * @return  the 'Vector' itself after adding values
     */
    fun add(x: Double, y: Double, z: Double): Vector {
        this.x += x
        this.y += y
        this.z += z
        return this
    }

    /**
     * Adds (x, y, z) values to 'Vector'.
     *
     * @param   double  [Double] value to add to all 3-axis
     * @return  the 'Vector' itself after adding values
     */
    fun add(double: Double) = add(double, double, double)

    /**
     * Adds (x, y, z) values to 'Vector'.
     *
     * @param   vector  'Vector' to get (x, y, z) values to add to all 3-axis
     * @return  the 'Vector' itself after adding values
     */
    fun add(vector: Vector) = add(vector.x, vector.y, vector.z)

    /**
     * Subtracts (x, y, z) values from 'Vector'.
     *
     * @param   x   [Double] value to subtract from [Vector.x]
     * @param   y   [Double] value to subtract from [Vector.y]
     * @param   z   [Double] value to subtract from [Vector.z]
     * @return  the 'Vector' itself after subtracting values
     */
    fun subtract(x: Double, y: Double, z: Double): Vector {
        this.x -= x
        this.y -= y
        this.z -= z
        return this
    }

    /**
     * Subtracts (x, y, z) values from 'Vector'.
     *
     * @param   double  [Double] value to subtract from all 3-axis
     * @return  the 'Vector' itself after subtracting values
     */
    fun subtract(double: Double) = subtract(double, double, double)

    /**
     * Subtracts (x, y, z) values from 'Vector'.
     *
     * @param   vector  'Vector' to get (x, y, z) values to subtract from all 3-axis
     * @return  the 'Vector' itself after subtracting values
     */
    fun subtract(vector: Vector) = subtract(vector.x, vector.y, vector.z)

    /**
     * Multiplies (x, y, z) values to 'Vector'.
     *
     * @param   x   [Double] value to subtract from [Vector.x]
     * @param   y   [Double] value to subtract from [Vector.y]
     * @param   z   [Double] value to subtract from [Vector.z]
     * @return  the 'Vector' itself after multiplying values
     */
    fun multiply(x: Double, y: Double, z: Double): Vector {
        this.x *= x
        this.y *= y
        this.z *= z
        return this
    }

    /**
     * Multiplies (x, y, z) values to 'Vector'.
     *
     * @param   double  [Double] value to subtract from all 3-axis
     * @return  the 'Vector' itself after multiplying values
     */
    fun multiply(double: Double) = multiply(double, double, double)

    /**
     * Multiplies (x, y, z) values to 'Vector'.
     *
     * @param   vector  'Vector' to get (x, y, z) values to multiply to all 3-axis
     * @return  the 'Vector' itself after multiplying values
     */
    fun multiply(vector: Vector): Vector = multiply(vector.x, vector.y, vector.z)

    /**
     * Divides (x, y, z) values into 'Vector'.
     *
     * @param   x   [Double] value to divide [Vector.x]
     * @param   y   [Double] value to divide [Vector.y]
     * @param   z   [Double] value to divide [Vector.z]
     * @return  the 'Vector' itself after dividing values
     */
    fun divide(x: Double, y: Double, z: Double): Vector {
        if(x != 0.0) this.x /= x
        if(y != 0.0) this.y /= y
        if(z != 0.0) this.z /= z
        return this
    }

    /**
     * Divides (x, y, z) values into 'Vector'.
     *
     * @param   double  [Double] value to divide all 3-axis
     * @return  the 'Vector' itself after dividing values
     */
    fun divide(double: Double) = divide(double, double, double)

    /**
     * Divides (x, y, z) values into 'Vector'.
     *
     * @param   vector  'Vector' to get (x, y, z) values to divide all 3-axis
     * @return  the 'Vector' itself after dividing values
     */
    fun divide(vector: Vector) = divide(vector.x, vector.y, vector.z)

    /**
     * Rotates pitch with the given value.
     *
     * @param   pitch   [Double] value to rotate pitch
     * @return  the 'Vector' itself after rotating
     */
    fun rotatePitch(pitch: Double): Vector {
        val cos = cos(toRadians(pitch))
        val sin =  sin(toRadians(pitch))
        y = y * cos - z * sin
        z = z * cos + y * sin
        return this
    }

    /**
     * Rotates yaw with the given value.
     *
     * @param   yaw   [Double] value to rotate yaw
     * @return  the 'Vector' itself after rotating
     */
    fun rotateYaw(yaw: Double): Vector {
        val cos = cos(toRadians(yaw))
        val sin = sin(toRadians(yaw))
        x = x * cos - z * sin
        z = z * cos + x * sin
        return this
    }

    /**
     * Rotates roll with the given value.
     *
     * @param   roll   [Double] value to rotate roll
     * @return  the 'Vector' itself after rotating
     */
    fun rotateRoll(roll: Double): Vector {
        val cos = cos(toRadians(roll))
        val sin = sin(toRadians(roll))
        x = x * cos - y * sin
        y = y * cos + x * sin
        return this
    }

    /**
     * Sets all 3-axis to zero.
     *
     * @return  the 'Vector' itself after setting zero
     */
    fun zero() = set(0.0)

    /**
     * Sets all 3-axis with random [Double] value (pseudorandomly with a positive sign,
     * greater than or equal to '0.0' and less than '1.0').
     *
     * @return  the 'Vector' itself after setting random values
     */
    fun random() = set(
        MathHelper.random(),
        MathHelper.random(),
        MathHelper.random()
    )

    /**
     * Normalizes the vector (sets the length of vector to 1.0).
     *
     * @return  the 'Vector' itself after normalizing it
     */
    fun normalize() = divide(length())

    /**
     * Returns the length of the vector
     *
     * @return  the length in [Double]
     */
    fun length() = sqrt(x.pow(2) + y.pow(2) + z.pow(2))

    /**
     * Returns the distance between this 'Vector' and the given (x, y, z).
     *
     * @param   x   [Double] value to compare with 'Vector'
     * @param   y   [Double] value to compare with 'Vector'
     * @param   z   [Double] value to compare with 'Vector'
     * @return  the distance in [Double]
     */
    fun distance(x: Double, y: Double, z: Double) =
        sqrt((x - this.x).pow(2) + (y - this.y).pow(2) + (z - this.z).pow(2))

    /**
     * Returns the distance between this 'Vector' and the given 'Vector'.
     *
     * @param   vector  'Vector' to compare with this 'Vector'
     * @return  the distance in [Double]
     */
    fun distance(vector: Vector) = distance(vector.x, vector.y, vector.z)

    /**
     * Returns the new 'Vector' by copying this 'Vector'.
     *
     * @return  Copied 'Vector'
     */
    fun copy() = Vector(x, y, z)

    /**
     * Calculates the hash code of the Vector,
     * using the well-known hash code algorithm.
     *
     * @return  the hash code in [Int]
     */
    override fun hashCode(): Int {
        var hash = 7
        setOf(x, y, z).forEach {
            hash = 79 * hash + (it.toBits() xor it.toBits() ushr 32).toInt()
        }
        return hash
    }

    /**
     * Compares with the given element.
     * Returns true if given element is a 'Vector' (or equivalent) and
     * its (x, y, z) values equals this 'Vector''s (x, y, z) values
     */
    override fun equals(other: Any?) = if (other is Vector)
        x == other.x && y == other.y && z == other.z else false

    /**
     * Returns the [String] in a format of "vector(x, y, z)".
     *
     * @return  the result [String]
     */
    override fun toString() = "vector($x, $y, $z)"

    companion object {
        /**
         * Rotates pitch of the given iterator with the given value.
         *
         * @param   vectors [Iterable] collection of 'Vector'
         * @param   pitch   [Double] value to rotate pitch
         */
        fun rotatePitch(vectors: Iterable<Vector>, pitch: Double) =
            vectors.forEach { it.rotatePitch(pitch) }

        /**
         * Rotates yaw of the given iterator with the given value.
         *
         * @param   vectors [Iterable] collection of 'Vector'
         * @param   yaw   [Double] value to rotate yaw
         */
        fun rotateYaw(vectors: Iterable<Vector>, yaw: Double) =
            vectors.forEach { it.rotateYaw(yaw) }

        /**
         * Rotates roll of the given iterator with the given value.
         *
         * @param   vectors [Iterable] collection of 'Vector'
         * @param   roll   [Double] value to rotate roll
         */
        fun rotateRoll(vectors: Iterable<Vector>, roll: Double) =
            vectors.forEach { it.rotateRoll(roll) }
    }
}