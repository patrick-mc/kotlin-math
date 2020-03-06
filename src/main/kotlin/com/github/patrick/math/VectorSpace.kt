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
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * Contact me on <mailpatrickkr@gmail.com>
 */

package com.github.patrick.math

import java.lang.ref.SoftReference
import java.util.Collections.unmodifiableList
import java.util.function.Predicate

@Suppress("unused", "MemberVisibilityCanBePrivate")

/**
 * The 'VectorSpace' class is a useful utility to manage multiple vectors
 * easily.  It works like a [ArrayList], but unlike that, 'VectorSpace' can
 * easily add, remove, calculate, rotate, iterate, and copy elements with
 * a single use of method.
 *
 * You can simply create new 'VectorSpace' by 'VectorSpace(vectors)'.
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
class VectorSpace : Iterable<Vector?> {
    /**
     * The private [ArrayList] to store 'Vector'.
     */
    private val vectors: ArrayList<Vector>

    /**
     * The private unmodifiable [List] to store 'Vector', used at 'getVectors'
     */
    private var unmodifiableVectors: List<Vector>? = null

    /**
     * The private [SoftReference] to manage garbage
     */
    private var temp: SoftReference<VectorSpace>? = null

    /**
     * The constructor using 'vararg'.
     */
    constructor(vararg vector: Vector) {
        vectors = ArrayList(listOf(*vector))
    }

    /**
     * The constructor using [List].
     *
     * @param   list    [List] of 'Vector' to set 'vectors'
     */
    constructor(list: List<Vector>) {
        vectors = ArrayList(list)
    }

    /**
     * The constructor using initial Capacity of [ArrayList]
     *
     * @param   initCapacity    [Int] value for initializing 'vectors'
     */
    constructor(initCapacity: Int) {
        vectors = ArrayList(initCapacity)
    }

    /**
     * The private constructor using 'VectorSpace' itself.
     *
     * @param   vectorSpace 'VectorSpace' for construction
     */
    private constructor(vectorSpace: VectorSpace) {
        vectors = ArrayList(vectorSpace.vectors.size)
        vectorSpace.vectors.forEach { addVector(it) }
    }

    /**
     * Adds 'Vector' to 'vectors'
     *
     * @param   vector  'Vector' to add to 'vectors'
     */
    fun addVector(vector: Vector) {
        vectors.add(vector)
        clearTemp()
    }

    /**
     * Removes 'Vector' from 'vectors'; returns true if successfully removed
     *
     * @param   vector  'Vector' to remove from 'vectors'
     * @return  [Boolean] depending on successful result or not
     */
    fun removeVector(vector: Vector?): Boolean {
        if (vectors.remove(vector)) {
            clearTemp()
            return true
        }
        return false
    }

    /**
     * Removes 'Vector' from 'vectors' if it meets [Predicate];
     * returns true if successfully removed
     *
     * @param   filter  [Predicate] of the 'Vector'
     * @return  [Boolean] depending on successful result or not
     */
    fun removeVectorIf(filter: Predicate<Vector>?): Boolean {
        if (vectors.removeIf(filter!!)) {
            clearTemp()
            return true
        }
        return false
    }

    /**
     * Trims the capacity of 'vectors' to be the current size.
     */
    fun trimToSize() = vectors.trimToSize()

    /**
     * Adds (x, y, z) value to each 'Vector' of 'vectors'
     *
     * @param   x   x value to add in [Double]
     * @param   y   y value to add in [Double]
     * @param   z   z value to add in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun add(x: Double, y: Double, z: Double): VectorSpace {
        vectors.forEach { it.add(x, y, z) }
        return this
    }

    /**
     * Adds 'double' value to each 'Vector' of 'vectors'
     *
     * @param   double  the value to add in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun add(double: Double) = add(double, double, double)

    /**
     * Adds 'vector' (x, y, z) value to each 'Vector' of 'vectors'
     *
     * @param   vector  'Vector' to get (x, y, z) values to add
     * @return  the 'VectorSpace' itself
     */
    fun add(vector: Vector) = add(vector.x, vector.y, vector.z)

    /**
     * Subtracts (x, y, z) value from each 'Vector' of 'vectors'
     *
     * @param   x   x value to subtract in [Double]
     * @param   y   y value to subtract in [Double]
     * @param   z   z value to subtract in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun subtract(x: Double, y: Double, z: Double): VectorSpace {
        vectors.forEach { it.subtract(x, y, z) }
        return this
    }

    /**
     * Subtracts 'double' value from each 'Vector' of 'vectors'
     *
     * @param   double  the value to subtract in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun subtract(double: Double) = subtract(double, double, double)

    /**
     * Subtracts 'vector' (x, y, z) value from each 'Vector' of 'vectors'
     *
     * @param   vector  'Vector' to get (x, y, z) values to subtract
     * @return  the 'VectorSpace' itself
     */
    fun subtract(vector: Vector) = subtract(vector.x, vector.y, vector.z)

    /**
     * Multiplies (x, y, z) value to each 'Vector' of 'vectors'
     *
     * @param   x   x value to multiply in [Double]
     * @param   y   y value to multiply in [Double]
     * @param   z   z value to multiply in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun multiply(x: Double, y: Double, z: Double): VectorSpace {
        vectors.forEach { it.multiply(x, y, z) }
        return this
    }

    /**
     * Multiplies 'double' value to each 'Vector' of 'vectors'
     *
     * @param   double  the value to multiply in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun multiply(double: Double) = multiply(double, double, double)

    /**
     * Multiplies 'vector' (x, y, z) value to each 'Vector' of 'vectors'
     *
     * @param   vector  'Vector' to get (x, y, z) values to multiply
     * @return  the 'VectorSpace' itself
     */
    fun multiply(vector: Vector) = multiply(vector.x, vector.y, vector.z)

    /**
     * Divides (x, y, z) value into each 'Vector' of 'vectors'
     *
     * @param   x   x divisor in [Double]
     * @param   y   y divisor in [Double]
     * @param   z   z divisor in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun divide(x: Double, y: Double, z: Double): VectorSpace {
        vectors.forEach { it.divide(x, y, z) }
        return this
    }

    /**
     * Divides 'double' value into each 'Vector' of 'vectors'
     *
     * @param   double  the divisor in [Double]
     * @return  the 'VectorSpace' itself
     */
    fun divide(double: Double) = divide(double, double, double)

    /**
     * Divides 'vector' (x, y, z) value into each 'Vector' of 'vectors'
     *
     * @param   vector  'Vector' to get (x, y, z) divisors
     * @return  the 'VectorSpace' itself
     */
    fun divide(vector: Vector) = divide(vector.x, vector.y, vector.z)

    /**
     * Rotates pitch of each 'Vector' of 'vectors' with the given value
     *
     * @param   pitch   [Double] value to rotate pitch
     * @return  the 'VectorSpace' itself
     */
    fun rotatePitch(pitch: Double): VectorSpace {
        Vector.rotatePitch(vectors, pitch)
        return this
    }

    /**
     * Rotates yaw of each 'Vector' of 'vectors' with the given value
     *
     * @param   yaw [Double] value to rotate pitch
     * @return  the 'VectorSpace' itself
     */
    fun rotateYaw(yaw: Double): VectorSpace {
        Vector.rotateYaw(vectors, yaw)
        return this
    }

    /**
     * Rotates roll of each 'Vector' of 'vectors' with the given value
     *
     * @param   roll    [Double] value to rotate pitch
     * @return  the 'VectorSpace' itself
     */
    fun rotateRoll(roll: Double): VectorSpace {
        Vector.rotateRoll(vectors, roll)
        return this
    }

    /**
     * Gets [Iterator] of the 'vectors'
     *
     * @return  the [Iterator] of the 'Vector'
     */
    override fun iterator(): Iterator<Vector> {
        return vectors.iterator()
    }

    /**
     * Returns mirrored VectorSpace after cleaning garbage
     *
     * @return  mirrored 'VectorSpace' after [SoftReference]
     */

    fun temp(): VectorSpace? {
        var mirror = if (temp == null) null else temp!!.get()
        if (mirror == null) temp = SoftReference(
            VectorSpace(this)
            .also { mirror = it }) else {
            for (i in 0 until size()) mirror!!.vectors[i] = vectors[i]
        }
        return mirror
    }

    /**
     * Clears 'temp' garbage
     */
    fun clearTemp() {
        temp = null
    }

    /**
     * Gets [unmodifiableList] of 'vectors'
     *
     * @return  [unmodifiableList] of 'vectors'
     */
    fun getVectors(): List<Vector> = unmodifiableVectors ?: unmodifiableList(vectors)
        .also { unmodifiableVectors = it }

    /**
     * Gets size of 'vectors'
     *
     * @return  size of 'vectors' in [Int]
     */
    fun size() = vectors.size

    /**
     * Gets a new copied 'VectorSpace'
     *
     * @return  copied 'VectorSpace'
     */
    fun copy() = VectorSpace(this)
}