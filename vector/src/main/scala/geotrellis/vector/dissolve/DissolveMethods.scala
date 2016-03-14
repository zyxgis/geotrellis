/*
 * Copyright (c) 2014 Azavea.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package geotrellis.vector.dissolve

import geotrellis.util.MethodExtensions
import geotrellis.vector._

/** Dissolves the linear components
  * from a collection of geometries
  * into a set of maximal-length {@link Linestring}s
  * in which every unique segment appears once only.
  *
  * @note  This method does not work over Point, MultiPoint, or GeometryCollection types.
  */
trait DissolveMethods[G <: Geometry] extends MethodExtensions[G] {
  def dissolve: MultiLineMultiLineUnionResult =
    try {
      com.vividsolutions.jts.dissolve.LineDissolver.dissolve(self.jtsGeom)
    } catch {
      case _: java.lang.NullPointerException =>
        // If this is an empty multiline or multipolygon, the JTS code throws this exception.
        NoResult
    }
}
