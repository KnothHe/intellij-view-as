package com.github.knothhe.intellijviewas.services

import com.github.knothhe.intellijviewas.ViewAsBundle
import com.intellij.openapi.project.Project

class ViewAsProjectService(project: Project) {

    init {
        println(ViewAsBundle.message("projectService", project.name))
    }
}
