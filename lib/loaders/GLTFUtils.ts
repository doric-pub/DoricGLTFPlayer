import { uniqueId } from "doric";
import * as Three from "three";
/** When Object3D instances are targeted by animation, they need unique names. */
export function createUniqueName(originalName?: string) {
  const sanitizedName = Three.PropertyBinding.sanitizeNodeName(
    originalName || ""
  );
  return uniqueId(sanitizedName);
}
