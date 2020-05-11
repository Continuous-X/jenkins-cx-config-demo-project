
folder('Demo') {
    displayName('Demo')
    description('Demo Folder')
}

multiBranchJobs = [
        [
                name: 'jenkins-cx-shared-library',
                url: 'https://github.com/Continuous-X/jenkins-cx-shared-library'
        ]
]

multiBranchJobs.each { job ->
    multibranchPipelineJob(job.name) {
        displayName job.name
        branchSources {
            git {
                id(job.name)
                remote(job.url)
                includes('JENKINS-*')
            }
        }
        orphanedItemStrategy {
            discardOldItems {
                numToKeep(20)
            }
        }
    }
}