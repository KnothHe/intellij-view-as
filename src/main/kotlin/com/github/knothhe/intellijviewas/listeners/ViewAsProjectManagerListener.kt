package com.github.knothhe.intellijviewas.listeners

import com.github.knothhe.intellijviewas.services.ViewAsProjectService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

internal class ViewAsProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        project.service<ViewAsProjectService>()
    }
}
