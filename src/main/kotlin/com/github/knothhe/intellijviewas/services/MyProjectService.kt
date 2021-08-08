package com.github.knothhe.intellijviewas.services

import com.github.knothhe.intellijviewas.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
