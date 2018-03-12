package tsec.passwordhashers.imports

import tsec.passwordhashers.core._

sealed trait SCrypt

object SCrypt extends JCAPasswordPlatform[SCrypt] {

  private[tsec] def unsafeHashpw(p: Array[Byte]): String =
    SCryptUtil.scrypt(p, DefaultSCryptN, DefaultSCryptR, DefaultSCryptP)

  private[tsec] def unsafeCheckpw(p: Array[Byte], hash: PasswordHash[SCrypt]): Boolean =
    SCryptUtil.check(p, hash)
}
