package geotrellis.vector.affine

import geotrellis.util.MethodExtensions
import geotrellis.vector.Point

trait PointTransformationMethods extends MethodExtensions[Point] {
  def transform(trans: AffineTransformation) = trans.transform(self)

  def reflect(x: Double, y: Double): Point =
    Reflection(x, y).transform(self)

  def reflect(x0: Double, y0: Double, x1: Double, y1: Double): Point =
    Reflection(x0, y0, x1, y1).transform(self)

  def rotate(theta: Double): Point =
    Rotation(theta).transform(self)

  def rotate(sinTheta: Double, cosTheta: Double): Point =
    Rotation(sinTheta, cosTheta).transform(self)

  def scale(xscale: Double, yscale: Double): Point =
    Scaling(xscale, yscale).transform(self)

  def shear(xshear: Double, yshear: Double): Point =
    Shearing(xshear, yshear).transform(self)

  def translate(x: Double, y: Double): Point =
    Translation(x, y).transform(self)

}
