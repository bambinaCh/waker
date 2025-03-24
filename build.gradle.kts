// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*Quelle
*  Lint: https://developer.android.com/studio/write/lint?hl=de
*  Klint: ChatGPT
* */
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}