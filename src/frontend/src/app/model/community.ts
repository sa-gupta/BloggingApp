export class Community{
    communityId: number;
    communityName: string;
    communityDescription: string;
    totalMembers: number;
    onlineMembers: number;
    createdOn: Date;
    postRulesAllowed: Array<string>;
    postRulesDisAllowed: Array<string>;
    banningPolicy: Array<string>;
    flairs: Array<string>;

    constructor(communityId: number, communityName: string, communityDescription: string, totalMembers: number, 
        onlineMembers: number, createdOn: Date, postRulesAllowed: Array<string>, postRulesDisAllowed: Array<string>, 
        banningPolicy: Array<string>, flairs: Array<string>){

        this.communityId = communityId;
        this.communityName = communityName;
        this.communityDescription = communityDescription;
        this.totalMembers = totalMembers;
        this.onlineMembers = onlineMembers;
        this.createdOn = createdOn;
        this.postRulesAllowed = postRulesAllowed;
        this.postRulesDisAllowed = postRulesDisAllowed;
        this.banningPolicy = banningPolicy;
        this.flairs = flairs;
    }
}