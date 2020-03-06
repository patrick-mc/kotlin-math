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

import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import javax.swing.JLabel

@Suppress("unused", "MemberVisibilityCanBePrivate")

/**
 * The object 'VectorParser' contains methods for parsing image and text,
 * and convert them to 'VectorSpace', which is a collection of 'Vector'.
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
object VectorParser {
    /**
     * Parses [BufferedImage] to 'VectorSpace'
     *
     * @param   image   [BufferedImage] to be converted
     * @param   pixelSize   the [Double] value to be multiplied to 'Vector'
     * @return  parsed result in 'VectorSpace' containing [ArrayList] of 'Vector'
     */
    fun parseImage(image: BufferedImage, pixelSize: Double): VectorSpace {
        val width = image.width
        val height = image.height
        val vectors = ArrayList<Vector>(width * height)
        for (x in 0 until width)
            for (y in 0 until height)
                if (!setOf(0, -1).contains(image.getRGB(x, y)))
                    vectors.add(
                        Vector(
                            -(x - (width - 1) / 2.0) * pixelSize,
                            -(y - (height - 1) / 2.0) * pixelSize,
                            0.0
                        )
                    )
        vectors.trimToSize()
        return VectorSpace(vectors)
    }

    /**
     * Parses [String] with [Font] to 'VectorSpace'
     *
     * @param   text    [String] to be parsed
     * @param   font    [Font] of the 'text'
     * @param   pixelSize   the [Double] value to be multiplied to 'Vector'
     * @return  parsed result in 'VectorSpace' containing [ArrayList] of 'Vector'
     */
    fun parseText(text: String, font: Font, pixelSize: Double): VectorSpace {
        val metrics = JLabel().getFontMetrics(font)
        val image = BufferedImage(
            metrics.stringWidth(text),
            metrics.height,
            BufferedImage.TYPE_INT_ARGB)
        val graphic = image.createGraphics()
        graphic.font = font
        graphic.color = Color.BLACK
        graphic.drawString(text, 0, metrics.maxAscent)
        graphic.dispose()
        return parseImage(image, pixelSize)
    }
}