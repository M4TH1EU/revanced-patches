package app.revanced.patches.bcvmobile

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val bypassRootDetectionPatch = bytecodePatch(
    name = "Bypass root detection",
    description = "example",
) {
    compatibleWith("ch.bcv.mobile.android"("15.5.0"))

    execute {
        loginActivityOnCreateFingerprint.method.replaceInstruction(
            index = 0,
            """
            return-void
            """
        )

        m2Fingerprint.method.replaceInstruction(
            index = 10, """
            goto :cond_1d
            """
        )

        q2Fingerprint.method.replaceInstruction(
            index = 14, """
            goto :cond_24
            """
        )

        onResumeFingerprint.method.replaceInstruction(
            index = 22, """
            goto :cond_30
            """
        )
    }
}