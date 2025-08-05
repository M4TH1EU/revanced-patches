package app.revanced.patches.bcvmobile

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal val loginActivityOnCreateFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC)
    returns("V")
    parameters("Landroid/os/Bundle;")
    strings("isTablet", "ROOTED")
    custom { methodDef, classDef ->
        classDef.type == "Lch/bcv/mobile/android/activity/loginbanking/LoginBankingActivityPortrait;"
    }
}


internal val m2Fingerprint = fingerprint {
    accessFlags(AccessFlags.PROTECTED)
    returns("V")
    parameters()
    strings("ROOTED", "runOnUiThread", "removeDialog")
//    opcodes(
//        Opcode.SGET_OBJECT,
//        Opcode.IF_NEZ,
//        Opcode.INVOKE_VIRTUAL,
//        Opcode.INVOKE_INTERFACE,
//        Opcode.MOVE_RESULT_OBJECT,
//        Opcode.IF_NE,
//        Opcode.NEW_INSTANCE,
//        Opcode.INVOKE_DIRECT,
//        Opcode.INVOKE_VIRTUAL
//    )
//    custom { (method, classDef) ->
//        classDef == "Lch/bcv/mobile/android/activity/loginbanking/a"
//    }
}

internal val q2Fingerprint = fingerprint {
    parameters("Ljava/lang/String;")
    returns("V")
    accessFlags(AccessFlags.PROTECTED)
    strings("ROOTED", "User is locally provisioned", "SDK context is null")
}

internal val onResumeFingerprint = fingerprint {
    returns("V")
    accessFlags(AccessFlags.PUBLIC)
    strings("onResume")
//    opcodes(
//        Opcode.INVOKE_VIRTUAL,
//        Opcode.MOVE_RESULT_OBJECT,
//        Opcode.INVOKE_VIRTUAL,
//        Opcode.MOVE_RESULT_OBJECT,
//        Opcode.CONST_STRING,
//        Opcode.INVOKE_STATIC,
//        Opcode.INVOKE_SUPER,
//        Opcode.CONST_4,
//        Opcode.IPUT_BOOLEAN,
//        null
//    )
    // ch.bcv.mobile.android.activity.main.BCVNetActivityPortrait
    custom { methodDef, classDef ->
        classDef.type == "Lch/bcv/mobile/android/activity/main/BCVNetActivityPortrait;" && methodDef.name == "onResume"
    }
}