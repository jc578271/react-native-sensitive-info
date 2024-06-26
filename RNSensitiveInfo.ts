import { NativeModules } from 'react-native';
import {IRNSensitiveInfo} from "./types";

const { RNSensitiveInfo } = NativeModules;

export * from "./types";
export default RNSensitiveInfo as IRNSensitiveInfo;




// {
//   ...RNSensitiveInfo,
  // setInvalidatedByBiometricEnrollment(
  //   invalidatedByBiometricEnrollment
  // ): Function {
  //   if (RNSensitiveInfo.setInvalidatedByBiometricEnrollment == null) {
  //     return;
  //   }

  //   return RNSensitiveInfo.setInvalidatedByBiometricEnrollment(
  //     invalidatedByBiometricEnrollment
  //   );
  // },
  // cancelFingerprintAuth() {
  //   if (RNSensitiveInfo.cancelFingerprintAuth == null) {
  //     return;
  //   }

  //   return RNSensitiveInfo.cancelFingerprintAuth();
  // },
// };
